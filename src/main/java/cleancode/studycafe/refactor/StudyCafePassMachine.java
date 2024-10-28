package cleancode.studycafe.refactor;

import cleancode.studycafe.refactor.exception.StudyCafeAppException;
import cleancode.studycafe.refactor.handler.StudyCafeInformationHandler;
import cleancode.studycafe.refactor.io.InputHandler;
import cleancode.studycafe.refactor.io.OutputHandler;
import cleancode.studycafe.refactor.model.StudyCafePassType;
import cleancode.studycafe.refactor.model.locker.StudyCafeLockerPass;
import cleancode.studycafe.refactor.model.pass.StudyCafePass;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import static cleancode.studycafe.refactor.model.StudyCafePassType.FIXED;
import static cleancode.studycafe.refactor.model.StudyCafePassType.HOURLY;
import static cleancode.studycafe.refactor.model.StudyCafePassType.WEEKLY;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    private final List<StudyCafePass> studyCafePasses;
    private final List<StudyCafeLockerPass> lockerPasses;

    public StudyCafePassMachine(StudyCafeInformationHandler studyCafeInformationHandler) {
        studyCafePasses = studyCafeInformationHandler.readStudyCafePasses();
        lockerPasses = studyCafeInformationHandler.readLockerPasses();
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();

            outputHandler.askPassTypeSelection();
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();

            switch (studyCafePassType) {
                case HOURLY -> {
                    List<StudyCafePass> hourlyPasses = findStudyCafePassesBy(studyCafePasses, HOURLY);
                    outputHandler.showPassListForSelection(hourlyPasses);

                    StudyCafePass selectedPass = inputHandler.getSelectPass(hourlyPasses);
                    outputHandler.showPassOrderSummary(selectedPass, null);
                }
                case WEEKLY -> {
                    List<StudyCafePass> weeklyPasses = findStudyCafePassesBy(studyCafePasses, WEEKLY);
                    outputHandler.showPassListForSelection(weeklyPasses);

                    StudyCafePass selectedPass = inputHandler.getSelectPass(weeklyPasses);
                    outputHandler.showPassOrderSummary(selectedPass, null);
                }
                case FIXED -> {
                    List<StudyCafePass> fixedPasses = findStudyCafePassesBy(studyCafePasses, FIXED);
                    outputHandler.showPassListForSelection(fixedPasses);

                    StudyCafePass selectedPass = inputHandler.getSelectPass(fixedPasses);
                    Optional<StudyCafeLockerPass> selectedStudyCafeLockerPass = getSelectedStudyCafeLockerPass(
                        lockerPasses, selectedPass
                    );

                    AtomicBoolean lockerSelection = new AtomicBoolean(false);
                    selectedStudyCafeLockerPass.ifPresent(lockerPass -> {
                        outputHandler.askLockerPass(lockerPass);
                        lockerSelection.set(inputHandler.getLockerSelection());
                    });

                    if (lockerSelection.get())
                        outputHandler.showPassOrderSummary(selectedPass);
                    else
                        outputHandler.showPassOrderSummary(selectedPass, null);
                }
            }
        } catch (StudyCafeAppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private Optional<StudyCafeLockerPass> getSelectedStudyCafeLockerPass(List<StudyCafeLockerPass> lockerPasses, StudyCafePass selectedPass) {
        return lockerPasses.stream()
            .filter(option ->
                option.getPassType() == selectedPass.getPassType() &&
                    option.getDuration() == selectedPass.getDuration()
            )
            .findFirst();
    }

    private List<StudyCafePass> findStudyCafePassesBy(List<StudyCafePass> passes, StudyCafePassType studyCafePassType) {
        return passes.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
            .toList();
    }

}

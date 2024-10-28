package cleancode.studycafe.refactor;

import cleancode.studycafe.refactor.handler.StudyCafeInformationHandler;
import cleancode.studycafe.refactor.handler.StudyCafeFileHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafeInformationHandler studyCafeInformationHandler = new StudyCafeFileHandler();
        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeInformationHandler);
        studyCafePassMachine.run();
    }

}

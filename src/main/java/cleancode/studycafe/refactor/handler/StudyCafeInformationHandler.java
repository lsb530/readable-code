package cleancode.studycafe.refactor.handler;

import cleancode.studycafe.refactor.model.locker.StudyCafeLockerPass;
import cleancode.studycafe.refactor.model.pass.StudyCafePass;

import java.util.List;

public interface StudyCafeInformationHandler {

    List<StudyCafePass> readStudyCafePasses();

    List<StudyCafeLockerPass> readLockerPasses();

}

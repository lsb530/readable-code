package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.*;
import cleancode.minesweeper.tobe.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.io.InputHandler;
import cleancode.minesweeper.tobe.io.OutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Beginner();
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        // Q. 만약 Minesweeper에 interface가 아닌 구체 클래스를 넣었다면?
        // A. DI(O), DIP(X)
        Minesweeper minesweeper = new Minesweeper(gameLevel, inputHandler, outputHandler);
        minesweeper.initialize();
        minesweeper.run();
    }

    /**
     * DIP (Dependency Inversion Principle)
     * : 고수준 모듈<->저수준 모듈(x)
     * : 고수준 모듈<- (추상화된 인터페이스) -> 저수준 모듈(o)
     * ------------------------------------
     * DI (Dependency Injection)
     * : 의존성 주입
     * : 필요한 의존성을 외부에서 직접 주입 받겠다
     * : 떠올려야 하는 숫자 "3"
     * : A, B가 있으면 제 3자가 이 A와 B를 관리해서 전달해야 한다
     * : 제3자 -> IoC 컨테이너(Spring Context)
     * ------------------------------------
     * IoC (Inversion of Control)
     * : 제어의 역전
     * : 프로그램의 흐름을 개발자가 아닌, 프레임워크가 담당하도록 하는 것
     * : 개발자는 이 프레임워크에 끼울 톱니바퀴 몇개정도를 개발하는 역할
     * : IoC 컨테이너가 하는 일(빈 관리)
     * : 1. 객체의 생성, 2. 객체의 소멸, 3. 의존성 주입까지
     */
}

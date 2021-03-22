package view;

import domain.dto.BoardDto;
import domain.dto.StatusDto;

public class OutputView {

    private OutputView() {
    }

    public static void showBoard(BoardDto boardDto) {
        boardDto.getMenuDto().forEach(System.out::print);
    }

    public static void showGuide() {
        System.out.println("> 체스 게임을 시작합니다.");
        System.out.println("> 게임 시작 : start");
        System.out.println("> 게임 종료 : end");
        System.out.println("> 게임 이동 : move source위치 target위치 - 예. move b2 b3");
    }

    public static void showCommandLine() {
        System.out.print("> ");
    }

    public static void showEndMessage() {
        System.out.println("체스가 종료됩니다.");
    }

    public static void alreadyStartGame() {
        System.out.println("게임이 이미 실행중입니다.");
    }

    public static void gameNotStart() {
        System.out.println("게임이 아직 실행되지 않았습니다.");
    }

    public static void showStatus(StatusDto statusDto) {
        statusDto.getMenuDto().entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue() + ""));
    }

    public static void invalidInputPosition(String command) {
        System.out.println("잘못된 위치 입력값입니다! (입력 : '" + command + "')");
    }

    public static void cannotMovePosition(String command) {
        System.out.println("해당 입력값으로 이동할 수 없습니다. (입력 : " + command + ")");
    }

    public static void cannotMovesamePosition(String command) {
        System.out.println("현재 위치와 동일한 위치로 이동할 수 없습니다.(입력 : " + command + ")");
    }
}

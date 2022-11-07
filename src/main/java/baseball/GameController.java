package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {
    private static final Boolean gameStart = true;
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        Boolean state = gameStart;
        GameSimulation gameSimulation = new GameSimulation(computer);
        while (state.equals(gameStart)) {
            gameSimulation.init();
            gameSimulation.playGame();
            success();

            String response = readLine();
            checkEndOfGame(response);
        }
    }

    private Boolean checkEndOfGame(String response) {
        if (response.equals("1")) {
            return true;
        }
        if (response.equals("2")) {
            return false;
        }
        if (!(response.equals("1") || response.equals("2"))) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }

        return true;
    }

    private void success() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하시려면 1, 종료하려면 2를 입력하세요.");
    }
}
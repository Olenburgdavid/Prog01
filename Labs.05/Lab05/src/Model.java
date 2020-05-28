public class Model {
    int row;
    int col;

    public void tryMoveRight() {
        if (col < 7) {
            ++col;
        }
    }

    public void tryMoveLeft() {
        if (col > 0) {
            --col;
        }
    }

    public void tryMoveUp() {
        if (row > 0) {
            --row;
        }
    }

    public void tryMoveDown() {
        if (row < 7) {
            ++row;
        }
    }
}


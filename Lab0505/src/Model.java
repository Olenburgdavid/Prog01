class Model {

    int row;
    int col;

    public void moveRight() {
        if (col < 7) {
            ++col;
        }
    }

    public void moveLeft() {
        if (col > 0) {
            --col;
        }
    }

    public void moveUp() {
        if (row > 0) {
            --row;
        }
    }

    public void moveDown() {
        if (row < 7) {
            ++row;
        }
    }
}
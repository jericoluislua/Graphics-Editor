public class FigurDAOStub implements FigurDAO {

    private String[] testFiguren = {"Rechteck, 10, 10, 200, 200",
                                    "Linie, 10, 120, 100, 1",
                                    "Kreis, 610, 5, 250"};

    private int currentFigur = 0;

    @Override
    public String[] readNextFigurData() {
        if(currentFigur < testFiguren.length){
            String[] figurData = testFiguren[currentFigur].split(", ");
            currentFigur++;
            return figurData;
        }

        return null;
    }
}

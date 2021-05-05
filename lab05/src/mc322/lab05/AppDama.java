public class AppDama {

    public static void main(String[] args) {
        if (args.length == 2) {
            AppDama.executaJogo(args[0], args[1]);
        } else {
            System.out.println("Quantidade inválida de argumentos");
        }
    }

    public static String[] executaJogo(String caminho_entrada, String caminho_saida) {

        // CSV Reader
        CSVHandling csv = new CSVHandling();
        csv.setDataSource(caminho_entrada);
        String commands[] = csv.requestCommands();

        // Instances
        BoardState boardState = new BoardState(commands.length + 1);
        BoardController boardController = new BoardController(boardState);

        // Main Logic
        for (int i = 0; i < commands.length; i++) {
            String[] coord = commands[i].split(":");
            System.out.println("\nSource: " + coord[0]);
            System.out.println("Target: " + coord[1]);
            boardController.executeCommand(commands[i]);
        }

        String[] exportString = boardState.convertStateToStringArray();

        // CSV Writer
        csv.setDataExport(caminho_saida);
        csv.exportState(exportString);

        return boardState.returnStateAsArrayofString();
    }
}
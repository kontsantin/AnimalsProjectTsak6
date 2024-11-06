package presenter;
import view.MessageView;
import view.InputView;

public class CommandHandler {
    private TreePresenter presenter;
    private MessageView messageView;
    private InputView inputView;

    public CommandHandler(TreePresenter presenter, MessageView messageView, InputView inputView) {
        this.presenter = presenter;
        this.messageView = messageView;
        this.inputView = inputView;
    }

    public void handleUserInput() {
        while (true) {
            messageView.displayMessage("Enter command (add, list, sortByName, sortByBirthYear, save, load, exit):");
            String command = inputView.getUserInput();
            switch (command) {
                case "add":
                    messageView.displayMessage("Enter name:");
                    String name = inputView.getUserInput();
                    messageView.displayMessage("Enter birth year:");
                    int birthYear = Integer.parseInt(inputView.getUserInput());
                    presenter.addPerson(name, birthYear);
                    break;
                case "list":
                    presenter.showAllPersons();
                    break;
                case "sortByName":
                    presenter.sortPersonsByName();
                    break;
                case "sortByBirthYear":
                    presenter.sortPersonsByBirthYear();
                    break;
                case "save":
                    messageView.displayMessage("Enter file name:");
                    presenter.saveTree(inputView.getUserInput());
                    break;
                case "load":
                    messageView.displayMessage("Enter file name:");
                    presenter.loadTree(inputView.getUserInput());
                    break;
                case "exit":
                    System.exit(0);
                default:
                    messageView.displayMessage("Unknown command");
            }
        }
    }
}

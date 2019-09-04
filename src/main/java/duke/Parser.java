package duke;

import duke.Commands.*;

public class Parser {

    public Command parseLine(String line, int listSize) {

        // remove all | characters from input
        line = line.replace("|","")
                .trim(); // remove leading and trailing spaces

        String[] tokens = line.split(" ",2);
        if (tokens.length == 0) {
            return new InvalidCommand();
        }
        switch(tokens[0].toLowerCase()) {
            case "list":
                return new ListCommand();

            case "done": case "delete":
                if (tokens.length != 2) {
                    return new InvalidCommand();
                }
                int index;
                try {
                    index = Integer.parseInt(tokens[1]) - 1;
                } catch(Exception ignored) {
                    return new InvalidCommand();
                }
                if (index < 0 || index >= listSize) {
                    return new InvalidCommand("Index not in bounds");
                }

                if (tokens[0].toLowerCase().equals("done")) {
                    return new DoneCommand(index);
                } else {
                    return new DeleteCommand(index);
                }


            case "todo": case "event": case "deadline":
                if (tokens.length != 2) {  return new InvalidCommand();  }
                String content = tokens[1];
                String[] subTokens = null;

                switch (tokens[0].toLowerCase()) {

                    case "todo": return new AddCommand(CommandType.TODO,content);
                    case "event": subTokens = content.split("/at"); break;
                    case "deadline": subTokens = content.split("/by"); break;
                }


                if (subTokens.length != 2 || subTokens[0].isBlank() || subTokens[1].isBlank()) {
                    return new InvalidCommand();
                }
                if (tokens[0].toLowerCase().equals("event")) {
                    return new AddCommand(CommandType.EVENT, subTokens[0], subTokens[1]);
                } else {
                    return new AddCommand(CommandType.DEADLINE, subTokens[0], subTokens[1]);
                }


            case "find":
                if (tokens.length != 2 || tokens[1].contains(" ")) {  return new InvalidCommand();  }

                String keyword = tokens[1];
                return new FindCommand(keyword);

            case "bye":
                return new ByeCommand();

        }


        return new InvalidCommand();

    }
}

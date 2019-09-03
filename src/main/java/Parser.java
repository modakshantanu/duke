import Commands.Command;

public class Parser {

    public Command parseLine(String line, int listSize) {


        // remove all | characters from input
        line = line.replace("|","")
                .trim(); // remove leading and trailing spaces

        String[] tokens = line.split(" ",2);
        if (tokens.length == 0) {
            return new Command(CommandType.INVALID);
        }
        switch(tokens[0].toLowerCase()) {
            case "list":
                return new Command(CommandType.LIST);

            case "done": case "delete":
                if (tokens.length > 2) {
                    return new Command(CommandType.INVALID);
                }
                int index;
                try {
                    index = Integer.parseInt(tokens[1]);
                } catch(Exception ignored) {
                    return new Command(CommandType.INVALID);
                }
                if (index < 0 || index >= listSize) {
                    return new Command(CommandType.INVALID, "Invalid Commands.Command. Index not in bounds");
                }

                if (tokens[0].toLowerCase().equals("done")) {
                    return new Command(CommandType.DONE).setTokens();
                } else {

                }







        }




    }
}

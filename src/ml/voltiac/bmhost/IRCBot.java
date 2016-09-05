package ml.voltiac.bmhost;

import org.jibble.pircbot.PircBot;

public class IRCBot extends PircBot {
	public IRCBot() {
		this.setName("MyBot");
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		String command = "";
		String[] args = {};
		
		
		if (message.startsWith("!")) {
			message = message.replaceFirst("!", "");
			args = message.split("\\s+");
			command = args[0];

			if (command.equalsIgnoreCase("CHECKIN")) {
				if (args.length <= 1) {
					sendMessage(channel, sender + ": Incorrect usage of command!");
				} else {
					sendMessage(channel, sender + ": You are now checked in!");
					sendMessage(channel, sender + ": -> NAME: " + args[1]);
					sendMessage(channel, sender + ": -> IP:   " + args[2]);
				}
			} else if (command.equalsIgnoreCase("FINDPLAYER")) {

			} else if (command.equalsIgnoreCase("GOTPLAYER")) {

			} else if (command.equalsIgnoreCase("FINDSERVER")) {

			} else if (command.equalsIgnoreCase("SERVERMSG")) {

			} else  if (command.equalsIgnoreCase("PLAYERMSG")) {
				
			} else {
				sendMessage(channel, sender + ": Unknown command!");
			}
			System.out.println(System.currentTimeMillis() + sender + " ran command: " + message);
		}else {
			System.out.println(System.currentTimeMillis() + "<" + sender + "> " + message);
		}
	}
}

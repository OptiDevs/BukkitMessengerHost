package ml.voltiac.bmhost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jibble.pircbot.Colors;
import org.jibble.pircbot.IrcException;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		IRCBot bot = new IRCBot();
		bot.setVerbose(true);
		bot.setName("BMHost");
		bot.setAutoNickChange(true);
		// Connect to the IRC server.
		try {
			bot.connect("wilhelm.freenode.net");
		} catch (IOException | IrcException e) {
			System.out.print(
					"Can't Connect to messageing servers. Contact the Develoepr (DiamondDeveloper) for more help!");
			return;
		}
		// Join the #Voltiac_BukkitMessenger channel.
		bot.joinChannel("#Voltiac_BukkitMessenger");

		bot.sendMessage("#Voltiac_BukkitMessenger", Colors.GREEN + "HOST ONLINE!");
		System.out.print("Connected to messaging servers!");

		String input;
		while (true) {

			try {
				input = br.readLine();
				if (input.startsWith("/")) {
					if (input.toLowerCase().startsWith("exit", 1)) {
						if (!input.contains("-s")) {
							bot.sendMessage("#Voltiac_BukkitMessenger", Colors.RED + "HOST OFFLINE!");
							bot.disconnect();
							System.out.println("Exiting.");
							return;
						}else {
							System.out.println("Exiting.");
							bot.disconnect();
						}
						return;
					} else {
						System.out.println("Unknown Command!");
					}
				} else {
					bot.sendRawLine("PRIVMSG #Voltiac_BukkitMessenger " + input);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

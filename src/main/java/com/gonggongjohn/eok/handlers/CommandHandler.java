package com.gonggongjohn.eok.handlers;

import com.gonggongjohn.eok.commands.CommandInspiration;
import com.gonggongjohn.eok.commands.CommandTestGuiScreen;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommandHandler {
	public static void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandTestGuiScreen());
		event.registerServerCommand(new CommandInspiration());
	}
}

package me.tekkitcommando.rankinfo;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class RankInfo
  extends JavaPlugin
{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static RankInfo plugin;
  
  public void onDisable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Is disabled!");
  }
  
  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Is enabled!");
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if (commandLabel.equalsIgnoreCase("staffperms"))
    {
      player.sendMessage(ChatColor.DARK_GREEN + "-------- " + ChatColor.YELLOW + ChatColor.BOLD + "Owner" + ChatColor.DARK_GREEN + " --------");
      player.sendMessage("");
      player.sendMessage(getConfig().getString("owner"));
      player.sendMessage("");
      player.sendMessage(ChatColor.DARK_GREEN + "-------- " + ChatColor.GOLD + ChatColor.BOLD + "Co-Owners" + ChatColor.DARK_GREEN + " --------");
      player.sendMessage("");
      player.sendMessage(getConfig().getString("coowners"));
      player.sendMessage("");
      player.sendMessage(ChatColor.DARK_GREEN + "-------- " + ChatColor.RED + ChatColor.BOLD + "Admins" + ChatColor.DARK_GREEN + " -------");
      player.sendMessage("");
      player.sendMessage(getConfig().getString("admins"));
      player.sendMessage("");
      player.sendMessage(ChatColor.DARK_GREEN + "-------- " + ChatColor.BLUE + ChatColor.BOLD + "Moderators" + ChatColor.DARK_GREEN + " -------");
      player.sendMessage("");
      player.sendMessage(getConfig().getString("mods"));
      player.sendMessage("");
      player.sendMessage(ChatColor.DARK_GREEN + "-------- " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Developers" + ChatColor.DARK_GREEN + " -------");
      player.sendMessage("");
      player.sendMessage(getConfig().getString("devs"));
      player.sendMessage("");
      player.sendMessage(ChatColor.DARK_GREEN + "- " + ChatColor.GRAY + "Developed by " + ChatColor.GRAY + ChatColor.UNDERLINE + "TekkitCommando" + ChatColor.DARK_GREEN + " -");
    }
    if ((commandLabel.equalsIgnoreCase("rankinfo")) && 
      (sender.hasPermission("ranks.infolist")))
    {
      player.sendMessage(ChatColor.LIGHT_PURPLE + "-------- " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Rank Info" + ChatColor.LIGHT_PURPLE + " --------");
      player.sendMessage("");
      player.sendMessage(getConfig().getString("rankperms"));
      return true;
    }
    return false;
  }
}

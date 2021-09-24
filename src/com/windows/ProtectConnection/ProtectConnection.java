package com.windows.ProtectConnection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ProtectConnection extends JavaPlugin
  implements Listener
{
  String prefix = ChatColor.YELLOW + "[WINDOWS] §b";
  private HashSet<String> ips = new HashSet<String>();
  private HashSet<String> ops = new HashSet<String>();
  List<String> z = new ArrayList<String>();
  List<String> x = new ArrayList<String>();
  private final String USER_AGENT = "Mozilla/5.0";
  private String Address = "http://ipip.kr";
  private URL Url;
  private BufferedReader br;
  private HttpURLConnection con;
  private String protocol = "GET";
  public static String IP = null;
  public static String Domain = "";
  
  public void DecompileProtect() {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
		list.stream().filter((Integer num) -> num % 2 == 0);
	}

  public void onEnable() {
		try {
			Url = new URL(this.Address);
		} catch (MalformedURLException e) {
		}
		try {
			con = (HttpURLConnection)Url.openConnection();
		} catch (IOException e) {
		}
		try {
			con.setRequestMethod(protocol);
		} catch (ProtocolException e) {
		}
		con.setRequestProperty("USER-Agent", USER_AGENT);
		try {
			br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		} catch (IOException e) {
		}
		String line;
		String ip = null;
		try {
			while((line = br.readLine())!= null){
			if (line.startsWith("<title>Your IP is ")){
				ip = line.replaceAll("Your IP is ", "").replaceAll("<title>", "").replaceAll("</title>", "");
			}
			}
		} catch (NullPointerException e1) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "                       [ Protect Connection ]");
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "인터넷 연결 상태가 올바르지 않습니다.");
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "서버를 종료합니다.");
				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
				try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
			}
				Bukkit.shutdown();
		} catch (IOException e) {
		}
		try {
			br.close();
		} catch (IOException e) {
		}
  	      try {
	  	        IP = InetAddress.getAllByName(Domain)[0].getHostAddress();
	  	        if (!ip.equalsIgnoreCase(IP)) {
	  	        	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "                       [ Protect Connection ]");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "구매자 도메인의 아이피와 일치하지 않습니다.");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "서버를 종료합니다.");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
	  				Thread.sleep(10000L);
	  				Bukkit.shutdown();
	  	        }
	  	      }
	  	      catch (UnknownHostException e1) {
		  	    	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "                       [ Protect Connection ]");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "구매 시 등록했던 도메인이 유효하지 않습니다.");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "서버를 종료합니다.");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
	  				try {
						Thread.sleep(10000L);
					} catch (InterruptedException e) {
					}
	  				Bukkit.shutdown();
	  	      } catch (InterruptedException e) {
			}
		  BufferedInputStream in = null;
			String strUrl = "http://cafe.naver.com/MemoList.nhn?search.clubid=27833593&search.menuid=5";
			StringBuffer sb = new StringBuffer();
			
			try {
				URL url = new URL(strUrl);
				URLConnection urlConnection = url.openConnection();
				in = new BufferedInputStream(urlConnection.getInputStream());
				
				byte[] bufRead = new byte[40960];
				int lenRead = 0;
				while ((lenRead = in.read(bufRead)) > 0)
					sb.append(new String(bufRead, 0, lenRead));

			} catch (IOException ioe) {}
			if (sb.toString().contains("[" + Domain + "]")) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "                       [ Protect Connection ]");
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "해당 플러그인은 현재 차단된 상태이므로 사용하실 수 없습니다.");
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "서버를 종료합니다.");
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e1) {
			}
			Bukkit.shutdown();
			return;
			}
    Bukkit.getPluginManager().registerEvents(this, this);
    File f = new File("plugins/Protect Connection");
    if (!f.exists())
    {
      f.mkdir();
    }
    File ip2 = new File("plugins/Protect Connection/허용아이피.txt");
    if (!ip2.exists())
      try {
        ip2.createNewFile();
      }
      catch (IOException localIOException) {
      }
    if (ip2.canRead())
      try {
        FileInputStream input = new FileInputStream(ip2);
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String playerLine = br.readLine();
        while (playerLine != null) {
            ips.add(playerLine);
            z.add(playerLine);
          playerLine = br.readLine();
        }
        br.close();
      } catch (IOException localIOException1) {
      }
    File op = new File("plugins/Protect Connection/오피목록.txt");
    if (!op.exists())
      try {
        op.createNewFile();
      }
      catch (IOException localIOException) {
      }
    if (op.canRead())
      try {
        FileInputStream input = new FileInputStream(op);
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String playerLine2 = br.readLine();
        while (playerLine2 != null) {
            ops.add(playerLine2.toLowerCase());
            x.add(playerLine2);
          playerLine2 = br.readLine();
        }
        br.close();
      } catch (IOException localIOException1) {
      }
    Bukkit.getConsoleSender().sendMessage(prefix + "§aProtect Connection 활성화");
    for (int n = 0; n < z.size(); n++)
      Bukkit.getConsoleSender().sendMessage(prefix + "§c허용된 아이피 : " + z.get(n));
    for (int n = 0; n < x.size(); n++)
    	Bukkit.getConsoleSender().sendMessage(prefix + "§c허용된 아이디 : " + x.get(n));
  }

  public static String readFile(File textFileName) throws IOException
  {
    FileReader fr = new FileReader(textFileName);

    String s = new String();
    int a;
    while ((a = fr.read()) != -1)
    {
      s = s + (char)a;
    }
    fr.close();
    return s;
  }
  
  public String getDate2() {
		return new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA).format(new Date());
	}
  
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onJoin(PlayerLoginEvent event) {
	  BufferedInputStream in = null;
		String strUrl = "http://cafe.naver.com/MemoList.nhn?search.clubid=27833593&search.menuid=5";
		StringBuffer sb = new StringBuffer();
		
		try {
			URL url = new URL(strUrl);
			URLConnection urlConnection = url.openConnection();
			in = new BufferedInputStream(urlConnection.getInputStream());
			
			byte[] bufRead = new byte[40960];
			int lenRead = 0;
			while ((lenRead = in.read(bufRead)) > 0)
				sb.append(new String(bufRead, 0, lenRead));

		} catch (IOException ioe) {}
		if (sb.toString().contains("[" + Domain + "]")) {
			event.disallow(null, "§4[WINDOWS]\n§e보안접속 플러그인이 제작자에 의해 차단되었습니다.");
			for (Player p : Bukkit.getOnlinePlayers()) {
			p.kickPlayer("§4[WINDOWS]\n§e보안접속 플러그인이 제작자에 의해 차단된 상태입니다.\n차단이 풀리기전까지 해당 플러그인을 사용할 수 없습니다.");
			}
			Bukkit.shutdown();
			} else if (sb.toString().contains("[" + event.getPlayer().getName().toLowerCase() + "]")) {
			event.disallow(null, "§4[WINDOWS] §e해당 아이디는 블랙리스트에 등록된 아이디입니다.");
			}
		try {
			Url = new URL(this.Address);
		} catch (MalformedURLException e) {
		}
		try {
			con = (HttpURLConnection)Url.openConnection();
		} catch (IOException e) {
		}
		try {
			con.setRequestMethod(protocol);
		} catch (ProtocolException e) {
		}
		con.setRequestProperty("USER-Agent", USER_AGENT);
		try {
			br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		} catch (IOException e) {
		}
		String line;
		String ip = null;
		try {
			while((line = br.readLine())!= null){
			if (line.startsWith("<title>Your IP is ")){
				ip = line.replaceAll("Your IP is ", "").replaceAll("<title>", "").replaceAll("</title>", "");
			}
			}
		} catch (IOException e) {
		}
		try {
			br.close();
		} catch (IOException e) {
		}
  	      try {
	  	        IP = InetAddress.getAllByName(Domain)[0].getHostAddress();
	  	        if (!ip.equalsIgnoreCase(IP)) {
	  	        	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "                       [ Protect Connection ]");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "구매자 도메인의 아이피와 일치하지 않습니다.");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "서버를 종료합니다.");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
	  				Thread.sleep(10000L);
	  				Bukkit.shutdown();
	  	        }
	  	      }
	  	      catch (UnknownHostException e1) {
		  	    	Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "                       [ Protect Connection ]");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "구매 시 등록했던 도메인이 유효하지 않습니다.");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "서버를 종료합니다.");
	  				Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●");
	  				try {
						Thread.sleep(10000L);
					} catch (InterruptedException e) {
					}
	  				Bukkit.shutdown();
	  	      } catch (InterruptedException e) {
			}
    Player player = event.getPlayer();
    if (player.isOp() && !ops.contains(player.getName().toLowerCase())) {
    	player.setOp(false);
    	return;
    }
    if (player.isOp() && !ips.contains(event.getAddress().getHostName())) {
      event.disallow(null, ChatColor.YELLOW + "[WINDOWS]\n\n" + ChatColor.DARK_RED + "관리자 아이디로 접속을 시도하셨습니다.\n\n§4접속한 이유를 해명하지 못할경우 처벌되며,\n\n§4괸라자가 검토 후 처리됩니다.");
      File f = new File("plugins/Protect Connection/" + getDate2() + ".txt");
      if (!f.exists())
      {
        try
        {
          FileOutputStream output = new FileOutputStream(f, true);
          output.flush();
          output.close();
        }
        catch (Exception localException)
        {
        }
      }
      try
      {
        String a = readFile(f);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        String b = new SimpleDateFormat("yyyy.MM.dd / HH:mm:ss", Locale.KOREA).format(new Date());
        String c = event.getAddress().getHostName();
        bw.write(a + "[" + b + "] " + player.getName() + " | " + c + "\r\n");
        bw.flush();
        bw.close();
      }
      catch (Exception localException1)
      {
      }
      return;
    }
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if (label.equalsIgnoreCase("pco")) {
    	  if (args.length == 1) {
    		  if (args[0].equalsIgnoreCase("reload")) {
    			  if (sender.hasPermission("admin")) {
    	ips.clear();
        z.clear();
        ops.clear();
        x.clear();
      File f = new File("plugins/Protect Connection");
      if (!f.exists())
      {
        f.mkdir();
      }
      File playerfile = new File("plugins/Protect Connection/허용아이피.txt");
      if (!playerfile.exists())
        try {
          playerfile.createNewFile();
        }
        catch (IOException localIOException) {
        }
      if (playerfile.canRead())
        try {
          FileInputStream input = new FileInputStream(playerfile);
          BufferedReader br = new BufferedReader(new InputStreamReader(input));
          String playerLine = br.readLine();
          while (playerLine != null) {
            ips.add(playerLine);
            z.add(playerLine);
            playerLine = br.readLine();
          }
          br.close();
        } catch (IOException localIOException1) {
        }
      File op = new File("plugins/Protect Connection/오피목록.txt");
      if (!op.exists())
        try {
          op.createNewFile();
        }
        catch (IOException localIOException) {
        }
      if (op.canRead())
        try {
          FileInputStream input = new FileInputStream(op);
          BufferedReader br = new BufferedReader(new InputStreamReader(input));
          String playerLine2 = br.readLine();
          while (playerLine2 != null) {
              ops.add(playerLine2.toLowerCase());
              x.add(playerLine2);
            playerLine2 = br.readLine();
          }
          br.close();
        } catch (IOException localIOException1) {
        }
      sender.sendMessage(prefix + "§aProtect Connection 리로드 완료");
      for (int n = 0; n < z.size(); n++) {
        sender.sendMessage(prefix + "§c허용된 아이피 : " + z.get(n));
      }
      for (int n = 0; n < x.size(); n++) {
      	sender.sendMessage(prefix + "§c허용된 아이디 : " + x.get(n));
      }
    			  }
    		  }
      }
    }

    return true;
  }
}
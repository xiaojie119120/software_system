package cn.jiesunshine.software_system.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.jiesunshine.software_system.entity.Software;
import cn.jiesunshine.software_system.entity.SoftwareExpand;
import cn.jiesunshine.software_system.entity.SoftwareShow;

public class SoftUtil {
	/***
	 * List<Software>--->List<SoftwareShow>
	 * @param softs
	 * @return
	 */
	public static List<SoftwareShow> softsToShows(List<? extends Software> softs) {
		List<SoftwareShow> shows = new ArrayList<SoftwareShow>();
		for (Software soft : softs) {
			shows.add(softToShow(soft));
		}
		
		return shows;
	}
	/***
	 * Software--->SoftwareShow
	 * @param soft
	 * @return
	 */
	public static SoftwareShow softToShow(Software soft) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SoftwareShow softwareShow = new SoftwareShow();
		SoftwareExpand softwareExpand = new SoftwareExpand();
		softwareExpand.setSoftSizeStr(SizeUtil.convertFileSize(soft.getSoftSize()));
		softwareExpand.setSoftDateStr(sdf.format(soft.getSoftDate()));
		softwareShow.setSoftwareExpand(softwareExpand);
		softwareShow.setSoftware(soft);
		return softwareShow;
	}
	/***
	 * List<Software>--->List<SoftwareShow> <span>key</span>
	 * @param softs
	 * @param key
	 * @return
	 */
	public static List<SoftwareShow> softToShowAndRedKey(List<Software> softs,String key) {
		List<SoftwareShow> shows = new ArrayList<SoftwareShow>();

		String wordReg = "(?i)"+key;//用(?i)来忽略大小写  
		for (Software soft : softs) {
			StringBuffer sb = new StringBuffer();  
			Matcher matcher = Pattern.compile(wordReg).matcher(soft.getSoftName());  
			if (matcher.find()){
				matcher.appendReplacement(sb, "<span>"+matcher.group()+"</span>");//这样保证了原文的大小写没有发生变化  
			}
			matcher.appendTail(sb);  
			soft.setSoftName(sb.toString());
			shows.add(softToShow(soft));
		}
		
		return shows;
	}
}

package com.apollo247.testing.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class HandleCookies {

	public boolean loadCookies(WebDriver driver, String filePath) {
		try {
			File file = new File(filePath);
			if (!file.exists() || file.length() == 0)
				return false;

			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, ";");
				String name = st.nextToken();
				String value = st.nextToken();
				String domain = st.nextToken();
				String path = st.nextToken();

				// Constructing the cookie - Apollo247 may need domain matching
				Cookie cookie = new Cookie.Builder(name, value).domain(domain).path(path).build();
				driver.manage().addCookie(cookie);
			}
			br.close();
			return true;
		} catch (Exception e) {
			System.out.println("❌ Error loading cookies: " + e.getMessage());
			return false;
		}
	}

	public void saveCookies(WebDriver driver, String filePath) {
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Total cookies found to save: " + cookies.size()); // Debug line

		if (cookies.isEmpty()) {
			System.out.println("⚠️ No cookies found in the browser session!");
			return;
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
			for (Cookie ck : cookies) {
				bw.write(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath());
				bw.newLine();
			}
			bw.flush(); // Ensure data is pushed to the file
			System.out.println("✅ Successfully wrote " + cookies.size() + " cookies to " + filePath);
		} catch (Exception e) {
			System.out.println("❌ Failed to write file: " + e.getMessage());
		}
	}
}
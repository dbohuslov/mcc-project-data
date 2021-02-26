package com.bah.mcc.logger;

public class ApiLogger {
		private static String module = "na";
		private static boolean on = true;

		public ApiLogger(String module) {
			ApiLogger.module = module;
		}

		public ApiLogger() {
		}

		public void mlog(String message) {
			System.out.println(module.toUpperCase() + ": " + message);
		}

		public static void log(String message) {
			System.out.println(module.toUpperCase() + ": " + message);
		}

		public static void on() {
			ApiLogger.setOn(true);
		}

		public static void off() {
			ApiLogger.setOn(true);
		}

		public static boolean isOn() {
			return on;
		}

		public static void setOn(boolean on) {
			ApiLogger.on = on;
		}

}

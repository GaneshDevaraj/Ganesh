package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;

public class GetConnectedDevices {

	public static List<String> GetDevices(String os) throws IOException, InterruptedException {

		List<String> hm = new ArrayList<String>();

		if (os.toLowerCase().equals("android")) {

			AndroidDebugBridge.init(false);
			AndroidDebugBridge adb = AndroidDebugBridge.createBridge();

			try {
				int trials = 10;
				while (trials > 0) {
					Thread.sleep(50);
					if (adb.isConnected()) {
						break;
					}
					trials--;
				}

				if (!adb.isConnected()) {
					System.out.println("Couldn't connect to ADB server");
				}

				trials = 10;
				while (trials > 0) {
					Thread.sleep(50);
					if (adb.hasInitialDeviceList()) {
						break;
					}
					trials--;
				}

				if (!adb.hasInitialDeviceList()) {
					System.out.println("Couldn't list connected devices");
				}

				if (adb.getDevices().length <= 0) {
					System.out.println("Couldn't list connected devices");
				}

				for (IDevice device : adb.getDevices()) {
					System.out.println("- " + device.getSerialNumber());
					hm.add(device.getSerialNumber());
				}
			} finally {
				AndroidDebugBridge.disconnectBridge();
				AndroidDebugBridge.terminate();
			}
			return hm;
		} else {
			Process proc = Runtime.getRuntime().exec("/usr/local/bin/idevice_id -l");
			try {
				proc.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			BufferedReader bf = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String DeviceList = "";
			DeviceList = bf.readLine();
			while (DeviceList != null) {
				hm.add(DeviceList);
				DeviceList = bf.readLine();
			}
			return hm;
		}

	}
}

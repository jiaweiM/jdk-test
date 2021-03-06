/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mjw.study.jdk.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 
 * @author JiaweiM
 * @version 14.11.2013 09:26:21
 */
public class UDPServer {
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(12345);
			byte[] buf = new byte[1000];
			DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
			System.out.println("��ʼ���հ�");

			while (true) {
				socket.receive(receivePacket);
				String name = receivePacket.getAddress().toString();
				System.out.println("��������" + name + "\n�˿ڣ�" + receivePacket.getPort());
				String string = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("������ݣ�" + string);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

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

/**
 * 
 * @version 1.00
 */

package cn.mjw.hello.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * echo ��������
 * ���ܣ����ͻ��˷��͵����ݷ������ͻ���
 * 
 * @author	JiaweiM
 * @date	Jul 7, 2015 2:24:19 PM
 */
public class TCPSocketServerTest {
	
	public static void main(String[] args){
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		
		// �����˿ں�
		int port = 10000;
		try {
			// ��������
			serverSocket = new ServerSocket(port);
			// �������
			socket = serverSocket.accept();
			// ���տͻ��˷�������
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int n = is.read(b);
			// ���
			System.out.println("�ͻ��˷�������Ϊ��"+ new String(b, 0, n));
			// ��ͻ��˷��ͷ�������
			os = socket.getOutputStream();
			os.write(b, 0, n);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				os.close();
				is.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
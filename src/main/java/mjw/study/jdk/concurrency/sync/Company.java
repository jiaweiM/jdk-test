/*
 * Copyright 2018 JiaweiMao jiaweiM_philo@hotmail.com
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

package mjw.study.jdk.concurrency.sync;

/**
 * 对账户进行充值
 *
 * @author JiaweiMao
 * @version 1.0.0
 * @since 18 Jan 2019, 1:10 PM
 */
public class Company implements Runnable
{
    private Account account;


    public Company(Account account)
    {
        this.account = account;
    }

    @Override public void run()
    {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
        }

    }
}

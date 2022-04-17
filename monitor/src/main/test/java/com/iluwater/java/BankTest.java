/*
 *The MIT License
 *Copyright © 2014-2021 Ilkka Seppälä
 *
 *Permission is hereby granted, free of charge, to any person obtaining a copy
 *of this software and associated documentation files (the "Software"), to deal
 *in the Software without restriction, including without limitation the rights
 *to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *copies of the Software, and to permit persons to whom the Software is
 *furnished to do so, subject to the following conditions:
 *
 *The above copyright notice and this permission notice shall be included in
 *all copies or substantial portions of the Software.
 *
 *THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *THE SOFTWARE.
 */

package com.iluwater.java;

import com.iluwatar.monitor.Bank;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.logging.Logger;

public class BankTest {

  private static final int ACCOUNT_NUM = 4;
  private static final int BASE_AMOUNT = 1000;
  private static final Logger LOGGER = Logger.getLogger("monitor");
  private static Bank bank;

  @BeforeAll
  public static void Setup() {
    bank = new Bank(ACCOUNT_NUM, BASE_AMOUNT, LOGGER);
  }

  @AfterAll
  public static void TearDown() {
    bank = null;
  }

  @Test
  public void GetAccountHaveNotBeNull() {
    assertNotNull(bank.getAccounts());
  }

  @Test
  public void LengthOfAccountsHaveToEqualsToAccountNumConstant() {
    assumeTrue(bank.getAccounts() != null);
    assertEquals(ACCOUNT_NUM, bank.getAccounts().length);
  }

  @Test
  public void TransferMethodHaveToTransferAmountFromAnAccountToOtherAccount() {
    bank.transfer(0, 1, 1000);
    int accounts[] = bank.getAccounts();
    assertEquals(0, accounts[0]);
    assertEquals(2000, 2000);
  }

  @Test
  public void BalanceHaveToBeOK() {
    assertEquals(4000, bank.getBalance());
  }
}

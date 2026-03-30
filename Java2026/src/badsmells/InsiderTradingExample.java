package badsmells;

/*
 * Smell: Insider Trading
 *
 * AuditService manipulates BankAccount internals directly. The classes know too
 * much about each other's data and become tightly coupled.
 *
 * Proposed Refactorings:
 * - Move account-specific decisions into BankAccount.
 * - Hide fields and expose intention-revealing methods instead.
 */
public class InsiderTradingExample {

	static class BankAccount {

		double balance;
		String secretFlag;
	}

	static class AuditService {

		public void freezeIfNeeded(BankAccount account) {
			if (account.balance < 0) {
				account.secretFlag = "FROZEN";
			}
		}
	}

	public void clientCode() {
		BankAccount account = new BankAccount();
		account.balance = -50;

		AuditService auditService = new AuditService();
		auditService.freezeIfNeeded(account);

		System.out.println(account.secretFlag);
	}
}

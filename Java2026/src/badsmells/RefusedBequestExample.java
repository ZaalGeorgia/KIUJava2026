package badsmells;

/*
 * Smell: Refused Bequest
 *
 * Penguin inherits from Bird but rejects part of the inherited contract by
 * throwing from fly(). That means the inheritance relationship is misleading.
 *
 * Proposed Refactorings:
 * - Replace inheritance with a better hierarchy or composition.
 * - Push flying behavior down only to birds that actually fly.
 */
public class RefusedBequestExample {

	static class Bird {

		public void fly() {
			System.out.println("Flying");
		}
	}

	static class Sparrow extends Bird {

		@Override
		public void fly() {
			System.out.println("Sparrow is flying");
		}
	}

	static class Eagle extends Bird {

		@Override
		public void fly() {
			System.out.println("Eagle is soaring");
		}
	}

	static class Penguin extends Bird {

		@Override
		public void fly() {
			throw new UnsupportedOperationException("Penguins do not fly");
		}
	}

	public void clientCode() {
		Bird sparrow = new Sparrow();
		Bird eagle = new Eagle();
		Bird penguin = new Penguin();

		sparrow.fly();
		eagle.fly();
		penguin.fly();
	}
}

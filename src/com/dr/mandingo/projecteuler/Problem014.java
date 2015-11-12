package com.dr.mandingo.projecteuler;

/**
 * Longest Collatz sequence
 * 
 * ============================================================================
 * 
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even)
 * 
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 It can be seen that this sequence
 * (starting at 13 and finishing at 1) contains 10 terms. Although it has not
 * been proved yet (Collatz Problem), it is thought that all starting numbers
 * finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 */
public class Problem014 {

	private final static int GATE_VALUE = 1000000;

	public FlagEntity[] flags = new FlagEntity[GATE_VALUE];

	public static void main(String[] args) {
		Problem014 p = new Problem014();
		for (int i = GATE_VALUE - 1; i >= 1; i--) {
			FlagEntity entity = new FlagEntity(i, i, 1);
			p.dig(entity);
		}
		System.out.print("the final result is:" + p.flags[0].source);
	}

	public void dig(FlagEntity target) {
		if (target.current < GATE_VALUE) {
			System.out.println(">>" + target.current + ">>" + target.source
					+ ">>" + target.chain);
			if (flags[(int) (target.current - 1)] == null
					|| flags[(int) (target.current - 1)].chain < target.chain) {
				flags[(int) (target.current - 1)] = target;
				if (target.current > 1) {
					FlagEntity entity = new FlagEntity(
							getValue(target.current), target.source,
							target.chain + 1);
					dig(entity);
				}
			}
		} else {
			FlagEntity entity = new FlagEntity(getValue(target.current),
					target.source, target.chain + 1);
			dig(entity);
		}
	}

	public long getValue(long target) {
		if (target % 2 == 0) {
			return target / 2;
		} else {
			return 3 * target + 1;
		}
	}

	public static class FlagEntity {

		public long current;

		public int source;

		public int chain;

		public FlagEntity(long current, int source, int chain) {
			this.current = current;
			this.source = source;
			this.chain = chain;
		}
	}

}

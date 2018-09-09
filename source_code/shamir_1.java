import java.math.BigInteger;
import java.util.Random;

//import shamir.SecretShare;

public final class shamir_1 {

	public final class SecretShare_1 {

		public SecretShare_1(final int num, final BigInteger share) {
			this.num = num;
			this.share = share;
		}

		public int getNum() {
			return num;
		}

		public BigInteger getShare_1() {
			return share;
		}

		@Override
		public String toString() {
			return "SecretShare [num=" + num + ", share=" + share + "]";
		}

		private final int num;
		private final BigInteger share;
	}

	public shamir_1(final int k, final int n) {
		this.k = k;
		this.n = n;

		random = new Random();
	}

	public int in1;
	public static int k;
	public static int n;
	public BigInteger prime;
	public Random random;

	public SecretShare_1[] split(final BigInteger secret) {

		final int modLength = secret.bitLength() + 1;
		prime = BigInteger.valueOf(251);

		final BigInteger[] coeff = new BigInteger[k - 1];

	//	System.out.println("Prime Number: " + prime);

		for (int i = 0; i < k - 1; i++) {
			// BigInteger bi = BigInteger.valueOf(myInteger.intValue());
			coeff[i] = BigInteger.valueOf(randomZp_1(in1));
//			System.out.println("a" + (i + 1) + ": " + coeff[i]);
		}

		final SecretShare_1[] shares = new SecretShare_1[n];
		for (int i = 1; i <= n; i++) {
			BigInteger accum = secret;

			for (int j = 1; j < k; j++) {
				final BigInteger t1 = BigInteger.valueOf(i).modPow(BigInteger.valueOf(j), prime);
				final BigInteger t2 = coeff[j - 1].multiply(t1).mod(prime);

				accum = accum.add(t2).mod(prime);
			}

			shares[i - 1] = this.new SecretShare_1(i - 1, accum);
//			System.out.println("Share " + shares[i - 1]);

		}
		return shares;
	}

	public BigInteger getPrime() {
		return prime;
	}

	public static BigInteger combine(final SecretShare_1[] shares, final BigInteger primeNum) {
		BigInteger accum = BigInteger.ZERO;

		for (int i = 0; i < k; i++) {
			BigInteger num = BigInteger.ONE;
			BigInteger den = BigInteger.ONE;

			for (int j = 0; j < k; j++) {
				if (i != j) {
					num = num.multiply(BigInteger.valueOf(-j - 1)).mod(primeNum);
					den = den.multiply(BigInteger.valueOf(i - j)).mod(primeNum);
				}
			}

//			System.out.println("den: " + den + ", num: " + den + ", inv: " + den.modInverse(primeNum));
			final BigInteger value = shares[i].getShare_1();

			final BigInteger tmp = value.multiply(num).multiply(den.modInverse(primeNum)).mod(primeNum);
			accum = accum.add(primeNum).add(tmp).mod(primeNum);

//			System.out.println("value: " + value + ", tmp: " + tmp + ", accum: " + accum);
		}

//		System.out.println("The secret is: " + accum);

		return accum;
	}

	private int randomZp_1(final int rand_1) {

		Random rand = new Random();
		int p = rand.nextInt(250);
		return p;

	}

	public static void main(final String[] args) {

		final shamir_1 shamir_1 = new shamir_1(3, 5);

		final BigInteger secret = new BigInteger("100");
		final SecretShare_1[] shares = shamir_1.split(secret);
		final BigInteger prime = shamir_1.getPrime();

		final shamir_1 shamir2 = new shamir_1(3, 5);
		final BigInteger prime_2 = BigInteger.valueOf(prime.intValue());
		final BigInteger result = shamir2.combine(shares, prime_2);

	}
}

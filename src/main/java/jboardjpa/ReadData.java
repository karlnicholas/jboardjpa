
package jboardjpa;

import javax.persistence.*;

public class ReadData {
	public static void main(String[] args) {
		new ReadData().run();
	}
	private void run() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jboardjpa");
	}

}

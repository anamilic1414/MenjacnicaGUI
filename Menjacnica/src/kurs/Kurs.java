package kurs;

public class Kurs {

	private double sifra;
	private String naziv;
	private String skraceni;
	private double prodajni;
	private double kupovni;
	private double srednji;

	public double getSifra() {
		return sifra;
	}

	public void setSifra(double sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.isEmpty())
			throw new RuntimeException("Morate uneti naziv!");
		this.naziv = naziv;
	}

	public String getSkraceni() {
		return skraceni;
	}

	public void setSkraceni(String skraceni) {
		if (skraceni == null || skraceni.isEmpty())
			throw new RuntimeException("Morate uneti skraceni naziv!");
		this.skraceni = skraceni;
	}

	public double getProdajni() {
		return prodajni;
	}

	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}

	public double getKupovni() {
		return kupovni;
	}

	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}

	public double getSrednji() {
		return srednji;
	}

	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}

	@Override
	public String toString() {
		return "Kurs [sifra=" + sifra + ", naziv=" + naziv + ", skraceni=" + skraceni + ", prodajni=" + prodajni
				+ ", kupovni=" + kupovni + ", srednji=" + srednji + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(kupovni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		temp = Double.doubleToLongBits(prodajni);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sifra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((skraceni == null) ? 0 : skraceni.hashCode());
		temp = Double.doubleToLongBits(srednji);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kurs other = (Kurs) obj;
		if (Double.doubleToLongBits(kupovni) != Double.doubleToLongBits(other.kupovni))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (Double.doubleToLongBits(prodajni) != Double.doubleToLongBits(other.prodajni))
			return false;
		if (Double.doubleToLongBits(sifra) != Double.doubleToLongBits(other.sifra))
			return false;
		if (skraceni == null) {
			if (other.skraceni != null)
				return false;
		} else if (!skraceni.equals(other.skraceni))
			return false;
		if (Double.doubleToLongBits(srednji) != Double.doubleToLongBits(other.srednji))
			return false;
		return true;
	}

	
}

public class City extends CityLayout{
    private String name;
    private int population;
    private int residential;
    private int commercial;
    private int industrial;
    private int rating;
    private int daysElapsed;
    private double tax;
    private int money;
    private int food;
    private int[][] cityLayout;
    private int[] houseNum = {3, 0, 1, 4, 7, 5};
    
    	
    City(String name) {
        this.name = name;
        this.population = 0;
        this.residential = 0;
        this.commercial = 0;
        this.industrial = 0;
        this.rating = 5;
        this.money = 500;
        this.daysElapsed = 1;
        this.food = 0;
        this.cityLayout = super.getMap(0);
    }
    
    //Getter Methods
    public int[][] getCityLayout() {
    	return this.cityLayout;
    }
    public void sortHouseNum() {
    	Sort sort = new Sort(this.houseNum);
    	sort.insertionSort();
    }
    public String getName() {
        return this.name;
    }
    public String getPopulation(){
        return String.valueOf(this.population);
    }
    public String getTax() {
    	return String.valueOf(this.tax);
    }
    public double getTaxNum() {
    	return this.tax;
    }
    public String getMoney() {
    	return String.valueOf(this.money);
    }
    public String getFood() {
    	return String.valueOf(this.food);
    }
    public String getRating() {
        return String.valueOf(this.rating);
    }
    public String getDaysElapsed() {
        return String.valueOf(this.daysElapsed);
    }
    
    //Setter methods
    public void setTax(double tax) {
    	this.tax = tax;
    }
    //Sets a value for tile in layout array
    public void setCityTile(int row, int col, int selection) {
    	this.cityLayout[row][col] = selection;
    	
    	if (selection == 7) {
    		this.residential += 1;
    		this.money -= 100;
    	}
    	if (selection == 8) {
    		this.commercial += 1;
    		this.money -= 300;
    	}
    	if (selection == 9) {
    		this.industrial += 1;
    		this.money -= 300;
    	}
    }
    
    //Executes end of day tasks
    public void nextDay() {
    	this.daysElapsed += 1;
    	checkPop();
    	eatFood();
    	
    }
    public void checkPop() {
    	if ((this.food / 3) > this.population) {
    		this.population = (this.residential * 3);
    	}
    	if (this.population < 0) {
    		this.population = 0;
    	}
    }
    
    
    public void collectMoney() {
        if (this.tax > 0.0) {
        this.money += (int)((population * 300) / this.tax);
        }
        else {
            this.money += 0;
        }
    }
    public void eatFood() {
        this.food -= this.population/3;
        if (this.food < 0) {
            this.population += this.food;
            this.food = 0;
        }
    }
    
    //Checkers
    public int checkMoney() {
        if (this.money < -500) {
            return 0;
        }
        else {
            return 1;
        }
         
    }
    public void checkTaxes() {
        if (this.tax > 10 && this.tax <= 20) {
            this.rating -= 10;
        }
        else if (this.tax > 20 && this.tax <= 50) {
            this.rating -= 20;
        }
        else if (this.tax > 50) {
            this.rating -= 30;
        }
    }
    public void checkRating() {
        if (this.rating <= 50 && this.rating > 20) {
            this.population -= (int)(Math.random() * 20);
        }
        else if (this.rating <= 20 && this.rating > 10) {
            this.population -= (int)(Math.random() * 30);
        }
        else if (this.rating <= 10 && this.rating > 20) {
            this.population -= (int)(Math.random() * 50);
        }
    }
    //Action
    public void buyFood(int foodAmount) {
        this.food += foodAmount;
        this.money -= (5 * foodAmount);
    }
    public void raiseTax(double tax) {
        this.tax = tax;
    }
    
    //Events
    public void fire() {
        this.population -= (int) (Math.random() * 1000);
    }
    public void murder() {
        population -= 3;
        rating -= 1.0;
    }
    public void setRating(int rating) {
         this.rating = rating;
    }
}
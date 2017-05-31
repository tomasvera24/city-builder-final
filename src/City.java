public class City extends CityLayout implements Events{
    
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
    private int murderDay;
    private int embezzlementDay;
    private int fireDay;
    private int earthquakeDay;
    
    	
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
        this.murderDay = ((int)Math.random() * 1000)+20;
        this.fireDay = ((int)Math.random() * 1000)+20;
        this.earthquakeDay = ((int)Math.random() * 1000)+20;
        this.embezzlementDay = ((int)Math.random() * 1000)+20;
    }
    
    //Getter Methods
    public int getScore() {
    	return (this.population * 10) + (this.residential * 5) + (this.industrial * 10) + (this.commercial * 5) + (this.daysElapsed * 5) + (this.rating * 5);
    }
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
    public void setRating(int rating) {
        this.rating = rating;
   }
    public void setTax(double tax) {
    	this.tax = tax;
    }
    public void setName(String name) {
    	this.name = name;
    }
    //Sets a value for tile in layout array
    public void setCityTile(int row, int col, int selection) {
    	
    	if (selection == 0) {
    		if (this.cityLayout[row][col] == 7) {
    			this.residential -= 1;
    		}
    		else if (this.cityLayout[row][col] == 8) {
    			this.commercial -= 1;
    		}
    		else if (this.cityLayout[row][col] == 9) {
    			this.industrial -= 1;
    		}
    	}
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
    		this.money -= 500;
    		this.rating -= 1;
    	}
    	this.cityLayout[row][col] = selection;
    }
    
    //Executes end of day tasks
    public boolean nextDay() {
    	this.daysElapsed += 1;
    	checkPop();
    	eatFood();
    	checkFood();
    	checkTax();
    	checkRating();
    	checkBuildings();
    	checkPopDay();
    	if (this.money < -500 || this.rating < 0) {
    		return false;
    	}
    	return true;
    }
    public void checkPop() {
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
    	if (this.population > 0) {
    		this.food -= 1;
    	}
    }
    
    //Checkers
    public void checkBuildings() {
    	this.money -= this.residential * 3;
    	this.money += this.commercial * 5;
    	this.money += this.industrial * 15;
    }
    public void checkFood() {
    	if (this.food < 0 && this.population > 0) {
        	this.rating -= 1;
        	this.food = 0;
        }
    	else if(this.food < 0) {
    		this.food = 0;
    	}
    }
    public void checkTax() {
    	this.money += (this.population*10) * (this.tax/100);
        if (this.tax > 10) {
        	this.rating -= 1;
        }
        if (this.tax <= 1) {
        	this.rating += 1;
        }
    }
    public void checkRating() {
    	if (this.rating > 20) {
    		this.rating = 20;
    	}
    }
    public void checkPopDay() {
    	if (this.population == 0 && this.daysElapsed > 10) {
    		this.rating -= 2;
    	}
    }
    
    //Action
    public void buyFood(int foodAmount) {
    	int foodCount = foodAmount;
    	if (this.population < (this.residential * 5)) {
    		foodCount = foodAmount - ((this.residential * 5) - this.population);
    		this.population += ((this.residential * 5) - this.population);
    	}
        this.food += foodCount;
        this.money -= (5 * foodAmount);
    }
    public void raiseTax(double tax) {
        this.tax = tax;
    }
    
    //Events
    public void murder() {
    	if (this.daysElapsed == this.murderDay) {
    		population -= 5;
            rating -= 1;
    	}
    }
    public void fire() {
    	if (this.daysElapsed == this.fireDay) {
    		this.population -= 20;
    		this.rating -= 3;
    	}
    };
	public void earthquake() {
		if (this.earthquakeDay == this.daysElapsed) {
			this.population -= 30;
			this.rating -= 2;
		}
	};
	public void embezzlement() {
		if (this.embezzlementDay == this.daysElapsed) {
			this.money -= 500;
		}
	};
    
}
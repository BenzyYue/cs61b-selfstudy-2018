public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double g = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dXSquare = (p.xxPos - this.xxPos) * (p.xxPos - this.xxPos);
        double dYSquare = (p.yyPos - this.yyPos) * (p.yyPos - this.yyPos);
        double rSquare = dXSquare + dYSquare;
        return Math.sqrt(rSquare);
    }

    public double calcForceExertedBy(Planet p){
        double distance = this.calcDistance(p);
        return (g * this.mass * p.mass) / (distance * distance);
    }

    public double calcForceExertedByX(Planet p){
        double totalForce = this.calcForceExertedBy(p);
        double distanceX = this.xxPos - p.xxPos;
        double distance = this.calcDistance(p);
        double forceByX = (totalForce * distanceX) / distance;
        if (forceByX < 0){
            forceByX = 0 - forceByX;
        }
        return forceByX;
    }

    public double calcForceExertedByY(Planet p){
        double totalForce = this.calcForceExertedBy(p);
        double distanceY = this.yyPos - p.yyPos;
        double distance = this.calcDistance(p);
        double forceByY = (totalForce * distanceY) / distance;
        if (forceByY < 0){
            forceByY = 0 - forceByY;
        }
        return forceByY;
    }

    public double calcNetForceExertedByX(Planet[] planets){
        double totalNetForceX = 0.0;
        for (Planet planet : planets){
            if (!this.equals(planet)){
                double netForceX = this.calcForceExertedByX(planet);
                if ((planet.xxPos - this.xxPos) < 0){
                    netForceX = 0 - netForceX;
                }
                totalNetForceX = totalNetForceX + netForceX;
            }
        }
        return totalNetForceX;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double totalNetForce = 0.0;
        for (Planet planet : planets){
            if (!(this.equals(planet))){
                double netForceY = this.calcForceExertedByY(planet);
                if ((planet.yyPos - this.yyPos) < 0){
                    netForceY = 0 - netForceY;
                }
                totalNetForce = totalNetForce + netForceY;
            }
        }
        return totalNetForce;
    }

    public void update(double dt, double xF, double yF){
        double accelerationX = xF / this.mass;
        double accelerationY = yF / this.mass;
        this.xxVel = this.xxVel + dt * accelerationX;
        this.yyVel = this.yyVel + dt * accelerationY;
        this.xxPos = this.xxPos + dt * xxVel;
        this.yyPos = this.yyPos + dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}

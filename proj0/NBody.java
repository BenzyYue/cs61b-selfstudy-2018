public class NBody {
    public static double readRadius(String file){
        In in = new In(file);
        int firstItem = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String file){
        In in = new In(file);
        int firstItem = in.readInt();
        double secondItem = in.readDouble();
        Planet[] planets = new Planet[firstItem];
        for (int i = 0 ; i < firstItem; i++){
            Planet planet = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(), in.readString());
            planets[i] = planet;
        }
        return planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet planet : planets){
            planet.draw();
        }

        StdDraw.enableDoubleBuffering();
        double iTemp = 0.0;
        while (iTemp < T){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            int count = 0;
            for (Planet planet : planets){
                xForces[count] = planet.calcNetForceExertedByX(planets);
                yForces[count] = planet.calcNetForceExertedByY(planets);
                planet.update(dt, xForces[count], yForces[count]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet planet : planets){
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            iTemp += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}

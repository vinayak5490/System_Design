package FareEstimator;

public class RideProApp {
    public interface VehiclePricingStrategy{
        double getFlatRate();
        double getPerKmRate();
    }
    public static class HatchbackPricing implements VehiclePricingStrategy{
        @Override
        public double getFlatRate(){
            return 5.0;
        }

        @Override
        public double getPerKmRate(){
            return 0.80;
        }
    }
    public static class LuxurySedanPricing implements VehiclePricingStrategy{
        @Override
        public double getFlatRate(){
            return 10.0;
        }

        @Override
        public double getPerKmRate(){
            return 1.20;
        }
    }
    public static class SUVPricing implements VehiclePricingStrategy{
        @Override
        public double getFlatRate(){
            return 12.0;
        }

        @Override
        public double getPerKmRate(){
            return 1.50;
        }
    }

    public static class ElectricScooterPricing implements VehiclePricingStrategy{
        @Override
        public double getFlatRate(){
            return 3.0;
        }
        @Override
        public double getPerKmRate(){
            return 0.50;
        }
    }

    public static class DiscountService{
        public double calculateDiscoutPercentage(int rideCount){
            double discount = 0.0;

            // First-time rider
            if(rideCount == 0){
                discount += 0.20;
            }

            //Loyalty discount
            if(rideCount > 10){
                discount += 0.15;
            }

            return discount;
        }
    }

    public static class FareEstimator{
        private static final double LONG_DISTANCE_RATE = 2.0;
        private static final int LONG_DISTANCE_THRESHOLD = 10;

        private DiscountService discountService;

        public FareEstimator(){
            this.discountService = new DiscountService();
        }

        public double estimateFare(VehiclePricingStrategy pricingStrategy, int distanceKm, int rideCount){
            double flatRate = pricingStrategy.getFlatRate();
            double perKmRate = pricingStrategy.getPerKmRate();

            if(distanceKm > LONG_DISTANCE_THRESHOLD){
                perKmRate = LONG_DISTANCE_RATE;
            }

            //Base fare calculation
            double totalFare = flatRate + (distanceKm * perKmRate);

            //apply discounts
            double discoutPercentage = discountService.calculateDiscoutPercentage(rideCount);
            totalFare = totalFare * (1-discoutPercentage);
            return totalFare;
        }
    }
    public static void main(String[] args) {
        FareEstimator fareEstimator = new FareEstimator();

        VehiclePricingStrategy vehicle = new HatchbackPricing();

        int distanceKm = 12;
        int rideCount = 11;

        double fare = fareEstimator.estimateFare(vehicle, distanceKm, rideCount);
        System.out.println("Total Fare : $" + fare);
    }
}

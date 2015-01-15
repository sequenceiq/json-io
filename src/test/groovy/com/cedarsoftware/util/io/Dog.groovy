package com.cedarsoftware.util.io;

/**
 * @author John DeRegnaucourt
 */
public class Dog
{
    public int x;

    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        return result;
    }

    public boolean equals(Object obj)
    {
        if (this.is(obj))
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Dog other = (Dog) obj;
        if (x != other.x)
        {
            return false;
        }
        return true;
    }

    public class Leg
    {
        public int y;

        public int getParentX()
        {
            return x;
        }

        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode()
            result = prime * result + y;
            return result;
        }

        public boolean equals(Object obj)
        {
            if (this.is(obj))
            {
                return true;
            }
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            Leg other = (Leg) obj;
            if (!getOuterType().equals(other.getOuterType()))
            {
                return false;
            }
            if (y != other.y)
            {
                return false;
            }
            return true;
        }

        private Dog getOuterType()
        {
            return Dog.this;
        }
    }

    public static class Shoe
    {
        private Shoe(Leg leg)
        {
            if (leg == null)
            {
                throw new IllegalArgumentException(
                        "A Shoe without a leg ... what a pity")
            }
        }

        public static Shoe construct()
        {
            return new Shoe(new Leg(new Dog()))
        }
    }

    public static class OtherShoe
    {
        private Leg leg;

        private OtherShoe(Leg leg)
        {
            if (leg == null)
            {
                throw new IllegalArgumentException("A Shoe without a leg ... what a pity")
            }
            this.leg = leg;
        }

        public static OtherShoe construct()
        {
            Leg leg2 = new Leg(new Dog())
            leg2.y = 5;
            return new OtherShoe(leg2)
        }

        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((leg == null) ? 0 : leg.hashCode())
            return result;
        }

        public boolean equals(Object obj)
        {
            if (this.is(obj))
            {
                return true;
            }
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            OtherShoe other = (OtherShoe) obj;
            if (leg == null)
            {
                if (other.leg != null)
                {
                    return false;
                }
            }
            else if (!leg.equals(other.leg))
            {
                return false;
            }
            return true;
        }

    }
}
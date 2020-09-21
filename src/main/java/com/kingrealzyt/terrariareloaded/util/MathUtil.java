package com.kingrealzyt.terrariareloaded.util;

import net.minecraft.util.math.AxisAlignedBB;

public class MathUtil {

    public static double calculateXOffset(AxisAlignedBB one, AxisAlignedBB other, double offsetX) {
        double oX = offsetX;
        if (other.maxY > one.minY && other.minY < one.maxY && other.maxZ > one.minZ && other.minZ < one.maxZ) {
            if (offsetX > 0.0 && other.maxX <= one.minX) {
                double d1 = one.minX - other.maxX;

                if (d1 < offsetX) {
                    oX = d1;
                }
            } else if (offsetX < 0.0 && other.minX >= one.maxX) {
                double d0 = one.maxX - other.minX;

                if (d0 > offsetX)
                    oX = d0;
            }
            return oX;
        } else {
            return offsetX;
        }
    }

    public static double calculateYOffset(AxisAlignedBB one, AxisAlignedBB other, double offsetY) {
        double oY = offsetY;
        if (other.maxX > one.minX && other.minX < one.maxX && other.maxZ > one.minZ && other.minZ < one.maxZ) {
            if (offsetY > 0.0 && other.maxY <= one.minY) {
                double d1 = one.minY - other.maxY;
                if (d1 < offsetY)
                    oY = d1;
            } else if (offsetY < 0.0 && other.minY >= one.maxY) {
                double d0 = one.maxY - other.minY;
                if (d0 > offsetY)
                    oY = d0;
            }
            return oY;
        } else {
            return offsetY;
        }
    }

    public static double calculateZOffset(AxisAlignedBB one, AxisAlignedBB other, double offsetZ) {
        double oZ = offsetZ;
        if (other.maxX > one.minX && other.minX < one.maxX && other.maxY > one.minY && other.minY < one.maxY) {
            if (offsetZ > 0.0 && other.maxZ <= one.minZ) {
                double d1 = one.minZ - other.maxZ;
                if (d1 < offsetZ)
                    oZ = d1;
            } else if (offsetZ < 0.0 && other.minZ >= one.maxZ) {
                double d0 = one.maxZ - other.minZ;
                if (d0 > offsetZ)
                    oZ = d0;
            }
            return oZ;
        } else {
            return offsetZ;
        }
    }

}

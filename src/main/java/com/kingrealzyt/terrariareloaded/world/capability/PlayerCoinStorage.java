package com.kingrealzyt.terrariareloaded.world.capability;

import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.util.LazyOptional;

/**
 * This class represent a storage for the player coins
 */
public class PlayerCoinStorage {

    private int bronze = 0;
    private int silver = 0;
    private int gold = 0;
    private int platinum = 0;

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setPlatinum(int platinum) {
        this.platinum = platinum;
    }

    /**
     * @param coin the coin type
     * @return the coin amount
     * @throws IllegalStateException if the coin is null or invalid
     */
    public int getAmount(Coin coin) {
        switch (coin) {
            case BRONZE:
                return this.bronze;
            case SILVER:
                return this.silver;
            case GOLD:
                return this.gold;
            case PLATINUM:
                return this.platinum;
            default:
                throw new IllegalStateException("Coin type not found");
        }
    }

    /**
     * Add coins.
     * <p>
     * When the amount of coins added is greater than 100 then it adds the next higher tier coin + 1
     * Example:
     * <p>
     * You have 60 bronze coins
     * You add 80 bronze coins
     * <p>
     * Then you have 40 bronze coins
     * And one silver coin more
     *
     * @param coin   the coin type
     * @param amount the amount to add
     * @throws IllegalStateException if the coin is null or invalid
     */
    public void add(Coin coin, int amount) {
        switch (coin) {
            case BRONZE:
                this.bronze += amount;
                if (this.bronze > 100) {
                    this.bronze = this.bronze - 100;
                    this.silver += 1;
                }
                break;
            case SILVER:
                this.silver += amount;
                if (this.silver > 100) {
                    this.silver = this.silver - 100;
                    this.gold += 1;
                }
                break;
            case GOLD:
                this.gold += amount;
                if (this.gold > 100) {
                    this.gold = this.gold - 100;
                    this.platinum += 1;
                }
                break;
            case PLATINUM:
                this.platinum += amount;
                break;
            default:
                throw new IllegalStateException("coin type not found");
        }
    }

    /**
     * Remove a amount of coins
     * If he have not enough coins, it will take from the higher tier
     *
     * @param coin   the coin type
     * @param amount the amount
     * @throws IllegalStateException if the coin is null or invalid
     */
    public void remove(Coin coin, int amount) {
        int[] res = this.calculateRemove(coin, amount);
        switch (coin) {
            case BRONZE:
                if (res[0] != -1 && res[1] != -1) {
                    this.bronze = res[0];
                    this.silver = res[1];
                }
                break;
            case SILVER:
                if (res[0] != -1 && res[1] != -1) {
                    this.silver = res[0];
                    this.gold = res[1];
                }
                break;
            case GOLD:
                if (res[0] != -1 && res[1] != -1) {
                    this.gold = res[0];
                    this.platinum = res[1];
                }
                break;
            case PLATINUM:
                this.platinum -= amount;
                break;
            default:
                throw new IllegalStateException("Coin type not found");
        }
    }

    /**
     * This method calculate the right amount to remove from the coins
     * If he have not enough, it will remove from the next higher tier
     *
     * @param coin   the coin type
     * @param amount the amount to remove
     * @return a int array. First index is the amount from the normal coin, and the second index is the coin amount from the higher tier
     */
    private int[] calculateRemove(Coin coin, int amount) {
        int[] res = new int[]{-1, -1};
        if (coin == Coin.PLATINUM) {
            return res;
        }
        Coin higher = this.getNext(coin);
        if (higher == null)
            return res;
        int c;
        int higherC;
        switch (coin) {
            case BRONZE:
                c = this.bronze;
                higherC = this.silver;
                break;
            case SILVER:
                c = this.silver;
                higherC = this.gold;
                break;
            case GOLD:
                c = this.gold;
                higherC = this.platinum;
                break;
            default:
                throw new IllegalStateException("Coin type not found");
        }
        int i = c - amount;
        if (i < 0) {
            int s = this.calculateHigherToLover(higher);
            if (s >= amount) {
                int i0 = s - Math.abs(i);
                int i1 = i0 % 100;
                int j = 0;
                for (int k = 0; k < Math.abs(i); k += 100)
                    j++;
                if (i1 == 0) {
                    c = i1;
                    higherC = i0 / 100;
                } else {
                    higherC = s / 100 - j;
                    c = i1;
                }
            }
        } else {
            c -= amount;
        }
        res[0] = c;
        res[1] = higherC;
        return res;
    }

    private Coin getNext(Coin coin) {
        switch (coin) {
            case BRONZE:
                return Coin.SILVER;
            case SILVER:
                return Coin.GOLD;
            case GOLD:
                return Coin.PLATINUM;
        }
        return null;
    }

    /**
     * Check if the player has enough coins. If he has not enough coins, it will check the next higher tier
     *
     * @param coin   the coin type
     * @param amount the amount to check
     * @return true if he had enough and fals if not
     */
    public boolean hasEnough(Coin coin, int amount) {
        switch (coin) {
            case BRONZE:
                return this.bronze >= amount || this.silver * 100 >= amount;
            case SILVER:
                return this.silver >= amount || this.gold * 100 >= amount;
            case GOLD:
                return this.gold >= amount || this.platinum * 100 >= amount;
            case PLATINUM:
                return this.platinum >= amount;
            default:
                throw new IllegalStateException("Coin type not found");
        }
    }

    private int calculateHigherToLover(Coin higher) {
        switch (higher) {
            case SILVER:
                return this.silver * 100;
            case GOLD:
                return this.gold * 100;
            case PLATINUM:
                return this.platinum * 100;
        }
        return -1;
    }

    public static class Capability {

        @CapabilityInject(PlayerCoinStorage.class)
        public static net.minecraftforge.common.capabilities.Capability<PlayerCoinStorage> PLAYER_STORAGE_CAP;

        public static LazyOptional<PlayerCoinStorage> getWorldPressure(final World world) {
            return world.getCapability(PLAYER_STORAGE_CAP, null);
        }

        public static net.minecraftforge.common.capabilities.Capability<PlayerCoinStorage> get() {
            return PLAYER_STORAGE_CAP;
        }

    }

    public static PlayerCoinStorage read(PacketBuffer data) {
        PlayerCoinStorage rsp = new PlayerCoinStorage();
        rsp.bronze = data.readInt();
        rsp.silver = data.readInt();
        rsp.gold = data.readInt();
        rsp.platinum = data.readInt();
        return rsp;
    }

    public enum Coin {

        BRONZE,
        SILVER,
        GOLD,
        PLATINUM

    }


}

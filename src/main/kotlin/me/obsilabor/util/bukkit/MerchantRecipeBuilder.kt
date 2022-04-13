package me.obsilabor.util.bukkit

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.MerchantRecipe

class MerchantRecipeBuilder(result: ItemStack) {

    private var recipe: MerchantRecipe

    init {
        recipe = MerchantRecipe(result, 128)
    }

    fun maxUses(maxUses: Int): MerchantRecipeBuilder {
        recipe.maxUses = maxUses
        return this
    }

    fun ingredient(itemStack: ItemStack): MerchantRecipeBuilder {
        recipe.addIngredient(itemStack)
        return this
    }

    fun emeralds(amount: Int): MerchantRecipeBuilder {
        if(amount > 128) {
            return this
        }
        return if(amount > 64) {
            val secondAmount = amount-64
            ingredient(ItemStack(Material.EMERALD, 64)).ingredient(ItemStack(Material.EMERALD, secondAmount))
        } else {
            ingredient(ItemStack(Material.EMERALD, amount))
        }
    }

    fun build(): MerchantRecipe {
        return recipe
    }

}
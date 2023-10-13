package com.nazlican.sisterslabproject.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NotNull

@Entity(tableName = "favorites")
data class ProductX(
    @ColumnInfo(name = "category") @NotNull val category: String,
    @ColumnInfo(name = "count") @NotNull val count: Int,
    @ColumnInfo(name = "description") @NotNull val description: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") @NotNull val id: Int,
    @ColumnInfo(name = "imageOne") @NotNull val imageOne: String,
    @ColumnInfo(name = "imageThree") @NotNull val imageThree: String,
    @ColumnInfo(name = "imageTwo") @NotNull val imageTwo: String,
    @ColumnInfo(name = "price") @NotNull val price: Double,
    @ColumnInfo(name = "rate") @NotNull val rate: Double,
    @ColumnInfo(name = "salePrice") @NotNull val salePrice: Double,
    @ColumnInfo(name = "saleState") @NotNull val saleState: Boolean,
    @ColumnInfo(name = "title") @NotNull val title: String
)
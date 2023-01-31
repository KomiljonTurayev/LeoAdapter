package me.komiljon.leo.viewpager

import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.Orientation
import me.komiljon.leo.LeoAdapter
import me.komiljon.leo.LeoAdapterDsl
import me.komiljon.leo.LeoItemBindListener
import me.komiljon.leo.LeoItemBinding
import me.komiljon.leo.core.LeoAdapterAsync
import me.komiljon.leo.core.LeoAdapterSync

@LeoAdapterDsl
fun <T,VB:ViewBinding> ViewPager2.setupAdapter(
    getViewBinding:LeoItemBinding<VB>,
    listener:LeoItemBindListener<T,VB>
):me.komiljon.leo.LeoAdapter<T>{

    val inflater:LayoutInflater = LayoutInflater.from(context)

    val leoAdapter:LeoAdapterSync<T,VB> = LeoAdapterSync(inflater,getViewBinding,listener)
    this.adapter = leoAdapter

    return leoAdapter

}

@LeoAdapterDsl
fun <T,VB:ViewBinding> ViewPager2.setupAdapter(
    @Orientation orientation: Int,
    getViewBinding: LeoItemBinding<VB>,
    listener: LeoItemBindListener<T, VB>
):LeoAdapter<T>{

    val inflater:LayoutInflater = LayoutInflater.from(context)
    this.orientation = orientation

    val leoAdapter:LeoAdapterSync<T,VB> = LeoAdapterSync(inflater,getViewBinding,listener)
    this.adapter = leoAdapter

    return leoAdapter
}

@LeoAdapterDsl
fun <T,VB:ViewBinding>ViewPager2.setupAdapter(
    getViewBinding: LeoItemBinding<VB>,
    diffUtil: DiffUtil.ItemCallback<T>,
    listener: LeoItemBindListener<T, VB>
):LeoAdapter<T>{

    val inflater:LayoutInflater = LayoutInflater.from(context)
    this.orientation = orientation

    val leoAdapter:LeoAdapterAsync<T,VB> = LeoAdapterAsync(inflater,diffUtil,getViewBinding,listener)
    this.adapter = leoAdapter

    return leoAdapter
}

@LeoAdapterDsl
fun <T,VB:ViewBinding>ViewPager2.setupAdapter(
    @Orientation orientation: Int,
    getViewBinding: LeoItemBinding<VB>,
    diffUtil: DiffUtil.ItemCallback<T>,
    listener: LeoItemBindListener<T, VB>
):LeoAdapter<T>{

    val inflater:LayoutInflater = LayoutInflater.from(context)
    this.orientation = orientation

    val leoAdapter:LeoAdapterAsync<T,VB> = LeoAdapterAsync(inflater,diffUtil,getViewBinding,listener)
    this.adapter = leoAdapter

    return leoAdapter

}
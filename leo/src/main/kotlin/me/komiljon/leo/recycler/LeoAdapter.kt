package me.komiljon.leo.recycler

import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import me.komiljon.leo.LeoAdapter
import me.komiljon.leo.LeoAdapterDsl
import me.komiljon.leo.LeoItemBindListener
import me.komiljon.leo.LeoItemBinding
import me.komiljon.leo.core.LeoAdapterAsync
import me.komiljon.leo.core.LeoAdapterSync

@LeoAdapterDsl
fun <T,VB:ViewBinding> RecyclerView.setupAdapter(
    getViewBinding: LeoItemBinding<VB>,
    layoutManager: LinearLayoutManager = LinearLayoutManager(context),
    listener: LeoItemBindListener<T,VB>
): LeoAdapter<T>{

    val inflater:LayoutInflater = LayoutInflater.from(context)
    this.layoutManager = layoutManager

    val leoAdapter:LeoAdapterSync<T,VB> = LeoAdapterSync(inflater,getViewBinding,listener)
    this.adapter = leoAdapter

    return leoAdapter
}

@LeoAdapterDsl
fun <T,VB:ViewBinding> RecyclerView.setupAdapter(
    getViewBinding: LeoItemBinding<VB>,
    diffUtil: DiffUtil.ItemCallback<T>,
    layoutManager: LinearLayoutManager = LinearLayoutManager(context),
    listener: LeoItemBindListener<T, VB>
):LeoAdapter<T>{

    val inflater:LayoutInflater = LayoutInflater.from(context)
    this.layoutManager = layoutManager

    val leoAdapter: LeoAdapterAsync<T, VB> = LeoAdapterAsync(inflater,diffUtil,getViewBinding,listener)
    this.adapter = leoAdapter

    return leoAdapter

}

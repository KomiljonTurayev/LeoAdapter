package me.komiljon.leo.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import me.komiljon.leo.LeoAdapter
import me.komiljon.leo.LeoItemBindListener
import me.komiljon.leo.LeoItemBinding

internal class LeoAdapterSync<T,VB:ViewBinding>(
    private val inflater: LayoutInflater,
    private val getViewBinding: LeoItemBinding<VB>,
    private val listener:LeoItemBindListener<T,VB>
):RecyclerView.Adapter<BaseVH<T,VB>>(),LeoAdapter<T> {

    private var _data:List<T> = emptyList()
    override fun onCreateViewHolder(parent:  ViewGroup, viewType: Int): BaseVH<T, VB> {
        val binding = getViewBinding(inflater,parent,false)
        return BaseVH(binding,listener)
    }

    override fun getItemCount() = _data.size

    override fun onBindViewHolder(holder: BaseVH<T, VB>, position: Int): Unit = holder(position, _data[position])

    override fun setList(data: List<T>) {
        _data = data
        notifyDataSetChanged()
    }
}

internal class LeoAdapterAsync<T,VB:ViewBinding>(
    private val inflater:LayoutInflater,
    diffUtil: DiffUtil.ItemCallback<T>,
    private val getViewBinding: LeoItemBinding<VB>,
    private val listener:LeoItemBindListener<T,VB>
):ListAdapter<T,BaseVH<T,VB>>(diffUtil),LeoAdapter<T>{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseVH<T, VB> {
        val binding = getViewBinding(inflater,parent,false)
        return BaseVH(binding,listener)
    }

    override fun onBindViewHolder(holder: BaseVH<T, VB>, position: Int) = holder(position,getItem(position))

    override fun setList(data: List<T>)  = submitList(data)

}
package com.devtides.whatappclone.listeners

import com.devtides.whatappclone.util.StatusListElement

interface StatusItemClickListener {
    fun onItemClicked(statusElement: StatusListElement)
}
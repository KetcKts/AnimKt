package tech.ketc.animkt.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_scale_anim.view.*
import tech.ketc.animkt.extension.animator.collapseMtrl
import tech.ketc.animkt.extension.animator.expandMtrl

class VPAScaleAnimationFragment : Fragment() {

    private var isCollapse = true
    private var isAnimate = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scale_anim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.expand_button.setOnClickListener {
            if (isCollapse && !isAnimate) {
                isAnimate = true
                view.content.expandMtrl(3f, 3f, onEnd = { isAnimate = false })
                isCollapse = false
            }
        }

        view.collapse_button.setOnClickListener {
            if (!isCollapse && !isAnimate) {
                isAnimate = true
                view.content.collapseMtrl { isAnimate = false }
                isCollapse = true
            }
        }

    }
}
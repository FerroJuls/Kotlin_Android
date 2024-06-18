package com.example.biblioteca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.biblioteca.config.config
import java.lang.Exception
import java.security.Guard

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [guardarLibroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class guardarLibroFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var txtTitulo:EditText
    private lateinit var txtAutor:EditText
    private lateinit var txtIsbn:EditText
    private lateinit var txtGenero:EditText
    private lateinit var txtNumEjemplarDisponible:EditText
    private lateinit var txtNumEjemplarOcupado:EditText
    private var id:String=""
    private lateinit var btnGuardar: Button
    fun guardarLibro(){
        try {
            if (id==""){// se crea el libro
                val request=object :StringRequest(
                    Request.Method.POST,
                    config.urllibro,
                    Response.Listener {
                        //metodo que se ejecujta cuando la peticion es correcta },
                        Toast.makeText(context,"Se guardo correctamente" , Toast.LENGTH_LONG).show()
                    },
                    Response.ErrorListener {
                        //metodo que se ejecujta cuando la peticion es error

                    }
                )
                {
                    //se agregan los datos para la peticion
                    override fun getParams(): Map<String, String> {
                        var parametros=HashMap<String, String>()
                        parametros.put("titulo", txtTitulo.text.toString())
                        parametros.put("autor", txtAutor.text.toString())
                        parametros.put("isbn", txtIsbn.text.toString())
                        parametros.put("genero", txtGenero.text.toString())
                        parametros.put("numEjemplarDisponible", txtNumEjemplarDisponible.text.toString())
                        parametros.put("numEjemplarOcupado", txtNumEjemplarOcupado.text.toString())
                        //uno por casa dato que requiera
                        return parametros
                    }
                }
                //secrea la cola de trabajo
                val queue=Volley.newRequestQueue(context)
                //se añade la peticion
                queue.add(request)
            }else{// se actualiza el libro

            }
        }catch (error:Exception){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_guardar_libro, container,false)
        txtTitulo=view.findViewById(R.id.txtTitulo)
        txtAutor=view.findViewById(R.id.txtAutor)
        txtIsbn=view.findViewById(R.id.txtIsbn)
        txtGenero=view.findViewById(R.id.txtGenero)
        txtNumEjemplarDisponible=view.findViewById(R.id.txtNumEjemplarDisponible)
        txtNumEjemplarOcupado=view.findViewById(R.id.txtNumEjemplarOcupado)
        btnGuardar=view.findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener {
            guardarLibro()
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment guardarLibroFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            guardarLibroFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
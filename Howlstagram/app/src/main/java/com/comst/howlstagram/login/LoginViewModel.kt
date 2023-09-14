package com.comst.howlstagram.login

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.comst.howlstagram.R
import com.facebook.AccessToken
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    var id : MutableLiveData<String> = MutableLiveData("")
    var password : MutableLiveData<String> = MutableLiveData("")

    var showInputNumberActivity : MutableLiveData<Boolean> = MutableLiveData(false)
    var showFindIdActivity : MutableLiveData<Boolean> = MutableLiveData(false)

    private var auth  = FirebaseAuth.getInstance()
    val context = getApplication<Application>().applicationContext
    var googleSignInClient : GoogleSignInClient
    init {
        //default_web_client_id 안 됨 => 아무거나
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(context,gso)
    }
    fun loginWithSignupEmail(){
        println("Email")
        auth.createUserWithEmailAndPassword(id.value.toString(), password.value.toString()).addOnCompleteListener {
            if (it.isSuccessful){
                showInputNumberActivity.value = true
            }else{
                // 아이디가 있을 경우
            }
        }
    }

    fun loginGoogle( view : View){
        var i = googleSignInClient.signInIntent
        (view.context as? LoginActivity)?.googleLoginResult?.launch(i)
    }

    // 암호화 푸는 코드
    fun firebaseAuthWithGoogle(idToken : String?){
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                showInputNumberActivity.value = true
            }else{
                // 아이디가 있을 경우
            }
        }
    }

    fun firebaseAuthWithFacebook(accessToken: AccessToken){
        val credential = FacebookAuthProvider.getCredential(accessToken.token)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                showInputNumberActivity.value = true
            }else{
                // 아이디가 있을 경우
            }
        }
    }
}
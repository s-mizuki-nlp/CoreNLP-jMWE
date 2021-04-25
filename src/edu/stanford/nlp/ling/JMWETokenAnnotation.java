
package edu.stanford.nlp.ling;
import edu.mit.jmwe.data.IMWE;
import edu.mit.jmwe.data.IToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbelousov on 28/11/2016.
 * Updated by S.Mizuki on 25/04/2021.
 */
public class JMWETokenAnnotation implements CoreAnnotation<String> {
    private String mwe_form = null;
    private IMWE<IToken> mwetoken = null;

    public JMWETokenAnnotation(IMWE<IToken> itoken){
        this.mwetoken = itoken;
        this.mwe_form = itoken.getForm();
    }

    public String get_lemmatized_form() {
        return this.mwetoken.getEntry().getForm();
    }

    public List<String> get_stem_forms() {
        List<String> lst_ret = new ArrayList<>();
        for (IToken itoken : this.mwetoken.getTokens()){
            lst_ret.addAll(itoken.getStems());
        }
        return lst_ret;
    }

    public List<String> get_surface_forms() {
        List<String> lst_ret = new ArrayList<>();
        for (IToken itoken : this.mwetoken.getTokens()){
            lst_ret.add(itoken.getForm());
        }
        return lst_ret;
    }

    public String get_part_of_speech(){
        return this.mwetoken.getEntry().getPOS().toString();
    }

    @Override
    public Class<String> getType() {
        return String.class;
    }

    @Override
    public String toString() {
        return  "surfaces=" + this.get_surface_forms() + '\\'
                + "stems=" + this.get_stem_forms() + '\\'
                + "lemma=" + this.get_lemmatized_form() + '\\'
                + "pos=" + this.get_part_of_speech() + '\\'
                ;
    }
}

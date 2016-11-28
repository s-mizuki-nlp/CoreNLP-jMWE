package edu.stanford.nlp.ling;

/**
 * Created by mbelousov on 28/11/2016.
 */
public class JMWETokenAnnotation implements CoreAnnotation<String> {
    private String mwe_form = null;

    public String getMWEForm() {
        return this.mwe_form;
    }

    public void setMWEForm(String value) {
        this.mwe_form = value;
    }

    @SuppressWarnings("unchecked")
    public Class<String> getType() {
        return String.class;
    }


}

package annotationsJava_Practice.reflexion;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflexion {

	public Object callGetter(Object obj, String fieldName)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		PropertyDescriptor pd;

		pd = new PropertyDescriptor(fieldName, obj.getClass());
		return pd.getReadMethod().invoke(obj);
	}

	public void callSetter(Object objeto, String nombreCampo, Object valor)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor descriptor;

		descriptor = new PropertyDescriptor(nombreCampo, objeto.getClass());
		descriptor.getWriteMethod().invoke(objeto, valor);
	}
	
	public void callMethod(Object objeto, String nombreMethod)
			throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Method metodo = objeto.getClass().getMethod(nombreMethod);
		
		metodo.invoke(objeto);
		}
}

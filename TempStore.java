package com.fisher.interfacetest.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Fisher on 10/16/2015.
 */
public class TempStore {
	public static final String sDefaultStoreName = "StoreDefault";

	private String name;
	private Context context;
	private SharedPreferences pm;
	private SharedPreferences.Editor editor;

	public static TempStore getStore( Context context, String name ) {
		return new TempStore( context, name );
	}
	public static TempStore getStore( Context context ) {
		return new TempStore( context, TempStore.sDefaultStoreName );
	}

	private TempStore( Context context, String name ) {
		this.context = context;
		this.name = name;

		pm = context.getSharedPreferences( name, Context.MODE_PRIVATE );
		editor = pm.edit();
	}


	public String getString( String key ) {
		return pm.getString( key, null );
	}
	public void setString( String key, String value ) {
		editor.putString( key, value );
		editor.commit();
	}

	public String[] getStrings( String key ) {
		Set< String > set = pm.getStringSet( key, null );
		Iterator it = set.iterator();
		String[] strings = new String[set.size()];
		for ( int i = 0; i < set.size(); i++ ) {
			strings[i] = ( String ) it.next();
		}
		return strings;
	}
	public void setStrings( String key, String[] strings ) {
		HashSet< String > set = new HashSet<>( strings.length );
		editor.putStringSet( key, set );
	}

	public boolean contains( String key ) {
		return pm.contains( key );
	}
	public void remove( String key ) {
		if ( contains( key ) )
			editor.remove( key );
	}
	public void clear( ) {
		editor.clear();
	}
}

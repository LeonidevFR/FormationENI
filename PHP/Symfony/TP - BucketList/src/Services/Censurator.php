<?php


namespace App\Services;


class Censurator
{

    const CENSURED_WORDS =
        ['encule', 'salope', 'pute', 'putes', 'merde', 'chier', 'bite', 'couilles', 'vagin', 'teub', 'techa', 'pussy', 'anus', 'enculé',
         'baise', 'sperme', 'mouille', 'viagra', 'baiser', 'sucer', 'cul', 'petasse', 'pétasse', 'prostituée', 'prostituee'];

    public function purify(string $text): string
    {
        //peut être fait en une ligne si on ne veut pas remplacer par un nombre précis d'*
        foreach(self::CENSURED_WORDS as $unwantedWord) {
            //autant d'* que de lettres dans le mot :
            $replacement = str_repeat("*", mb_strlen($unwantedWord));
            $text = str_ireplace($unwantedWord, $replacement, $text);
        }
        return $text;
    }

}